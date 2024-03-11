Collections.sort(reportList, Comparator.comparing(Report::getReportKey)
            .thenComparing(Report::getStudentNumber)
            .thenComparing(Report::getSchool));

=

Comparator<Report> comparator = Comparator.comparing(report -> report.getReportKey())
            .thenComparing(report -> report.getStudentNumber())
            .thenComparing(report -> report.getSchool());
Collection.sort(reportList, comparator);


Add .reversed() to the "comparing" that needs to be reversed
Comparator<Report> comparator = Comparator.comparing(report -> report.getReportKey())
            .thenComparing(report -> report.getStudentNumber()).reversed()
            .thenComparing(report -> report.getSchool());
