package utils.xml

import groovy.xml.MarkupBuilder

class XmlTest {

    def testMarkupBuilder() {
        def mb_ = new MarkupBuilder(new File("E://book.xml").newPrintWriter());
        def result=mb_.book() {
            author('ken')
            title('Groovy')
            publisher('华章出版社')
            isbn(number:104552)
        }
        println result
    }

    def testXMlparser(){
        def xmlparser=new XmlParser();
        def book_xml=xmlparser.parse(new File("E://book.xml"))
        println book_xml.author.text()
        println book_xml.isbn['@number'].text()
        //
    }
}
