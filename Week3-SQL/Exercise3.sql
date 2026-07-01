UPDATE Loans
SET EndDate = SYSDATE + 20
WHERE LoanID = 1;

COMMIT;
BEGIN
    FOR loan IN (
        SELECT LoanID, CustomerID, EndDate
        FROM Loans
        WHERE EndDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP

        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Customer '
            || loan.CustomerID
            || ' has a loan due on '
            || TO_CHAR(loan.EndDate, 'DD-MON-YYYY')
        );

    END LOOP;
END;
/
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
AS
BEGIN

    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountType = 'Savings';

    COMMIT;

END;
/
BEGIN
    ProcessMonthlyInterest;
END;
/
SELECT * FROM Accounts;
SELECT * FROM Accounts;
CREATE OR REPLACE PROCEDURE TransferFunds(
    p_fromAccount IN NUMBER,
    p_toAccount IN NUMBER,
    p_amount IN NUMBER
)
AS
    v_balance NUMBER;
BEGIN

    -- Get balance of source account
    SELECT Balance
    INTO v_balance
    FROM Accounts
    WHERE AccountID = p_fromAccount;

    -- Check sufficient balance
    IF v_balance >= p_amount THEN

        -- Deduct from source account
        UPDATE Accounts
        SET Balance = Balance - p_amount
        WHERE AccountID = p_fromAccount;

        -- Add to destination account
        UPDATE Accounts
        SET Balance = Balance + p_amount
        WHERE AccountID = p_toAccount;

        COMMIT;

        DBMS_OUTPUT.PUT_LINE('Transfer Successful.');

    ELSE

        DBMS_OUTPUT.PUT_LINE('Insufficient Balance.');

    END IF;

END;
/
BEGIN
    TransferFunds(1,2,500);
END;
/
SELECT * FROM Accounts;
BEGIN
    TransferFunds(1,2,5000);
END;
/