import xml.dom.minidom
import xml.sax

def main():
    print("DOM Parser")
    parse_dom()

    print("\n\n")
    print("SAX Parser")
    parse_sax()

def parse_dom():
    dom_tree = xml.dom.minidom.parse("books.xml")
    books = dom_tree.getElementsByTagName("book")

    print("Bücher in der Liste:")

    for book in books:
        title = book.getElementsByTagName("title")[0].firstChild.nodeValue
        author = book.getElementsByTagName("author")[0].firstChild.nodeValue

        print("-" * 10)
        print(f"Titel: {title}")
        print(f"Autor: {author}")

def parse_sax():
    parser = xml.sax.make_parser()
    handler = BookSAXHandler()
    parser.setContentHandler(handler)

    print("Bücher in der Liste:")
    parser.parse("books.xml")

class BookSAXHandler(xml.sax.ContentHandler):
    def __init__(self):
        self.current_tag = ""
        self.title = ""
        self.author = ""

    def startElement(self, tag, attributes):
        self.current_tag = tag
        if tag == "title":
            self.title = ""
        elif tag == "author":
            self.author = ""

    def characters(self, content):
        if self.current_tag == "title":
            self.title += content
        elif self.current_tag == "author":
            self.author += content

    def endElement(self, tag):
        if tag == "title":
            print("-" * 10)
            print(f"Titel: {self.title}")
        elif tag == "author":
            print(f"Autor*in: {self.author}")

        self.current_tag = ""

if __name__ == "__main__":
    main()