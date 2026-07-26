 public class Main {

    public static void main(String[] args) {

        DocumentFactory factory = new WordDocumentFactory();

        Document doc = factory.createDocument();

        doc.open();
    }
}
