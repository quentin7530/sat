//Reporting System
public enum ReportingType {
    SCV, XML,
}

public class ReportingService {
    public void generateReportBaseOnType(ReportingType){
        if("CSV".equalsIgnoreCase(ReportingType)){
            generateCSVReport();
        }else if("XML".equalsIgnoreCase(ReportingType)){
            generateXMLReport();
        }
    }

    public void generateCSVReport(){...}

    public void generateXMLReport(){...}
}

// 1. Erklären Sie wieso das Beispiel das Open-Closed-Prinzip verletzt.
// 2. Führen sie alle Codeänderungen durch, sodass Open-Closed-Prinzip
// eingehalten wird.