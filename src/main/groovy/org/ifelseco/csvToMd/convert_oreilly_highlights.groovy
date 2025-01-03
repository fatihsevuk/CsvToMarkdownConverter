package org.ifelseco.csvToMd

@Grab('org.apache.commons:commons-csv:1.10.0')
import org.apache.commons.csv.*

String templateH1="# h1Header"
String templateH2="## h2Header"
String templateJavaCode="""```lang
    code
```"""

// Check if the CSV file path is provided as an argument
if (args.size() != 2) {
    println "Usage: groovy script.groovy <path_to_csv_file> <codeFormattingLang:java,c#...>"
    System.exit(1)
}

// Get the CSV file path from the argument
def csvFilePath = args[0]
def codeLang = args[1]
def csvFile = new File(csvFilePath)
def mdFile = new File("./highlights.md")
String bookTitle
String chapterTitle

def lines = []
csvFile.withReader { reader ->
    CSVParser csv = new CSVParser(reader, CSVFormat.DEFAULT.withHeader())
    csv.toList().reverse().each { record ->
        // csvList.add(record.toMap())

        record.toMap().eachWithIndex{ def entry, int i ->
            StringBuilder highlight = new StringBuilder()
            highlight.append()
        }

        def valueList = record.toMap().entrySet().value.toArray()


        StringBuilder sb = new StringBuilder()

        if (bookTitle == null && chapterTitle == null) {

            bookTitle = valueList[0]
            chapterTitle = valueList[1]

            sb.append(templateH1.replace("h1Header",bookTitle))
                    .append("\n")
                    .append(templateH2.replace('h2Header',chapterTitle))
                    .append("\n")
        }


        String date = valueList[2]
        String highlight = valueList[6]
        String note = valueList[8]

        sb.append(date).append("\n")
                .append(templateJavaCode.replace("lang",codeLang).replace("code",highlight))
                .append("\n")
                .append(note)
                .append("\n")
                .append("__________________________________");



        lines.addAll(sb)

    }
}

mdFile.withWriter {out->
    lines.each {line->
        out.println(line)
    }
}

