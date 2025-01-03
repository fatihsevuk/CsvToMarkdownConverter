# Convert O'Reilly Highlights to Markdown

This script converts O'Reilly eBook highlights stored in a CSV file into a Markdown document for easier readability and sharing.

## Features
- Generates a Markdown file (`highlights.md`) from CSV highlights.
- Supports custom code formatting for highlights (e.g., Java, Python, C#).

## Requirements
- **Groovy** installed on your system.
- **CSV file** containing O'Reilly highlights.

## Installation
1. Install [Groovy](https://groovy-lang.org/install.html).
2. Clone or download this script.

## Usage
```bash  
groovy convert_oreilly_highlights.groovy <path_to_csv_file> <codeFormattingLang>
```

path_to_csv_file : The path to your O'Reilly highlights CSV file.

formattingLang : The programming language for code formatting in Markdown (e.g., java, python, c#).

Example
```bash  
groovy convert_oreilly_highlights.groovy highlights.csv java  
```

## Dependencies
- Apache Commons CSV library (`org.apache.commons:commons-csv:1.10.0`).

## Notes
- Ensure your CSV file includes columns like book title, chapter title, date, highlight, and note.
- The script processes highlights in reverse order, showing the latest highlights first.  