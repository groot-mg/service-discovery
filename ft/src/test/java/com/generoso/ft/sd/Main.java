package com.generoso.ft.sd;

public class Main {

    public static void main(String[] args) {
        var testArgs = new String[]{
            "--tags", "not @ignore",
            "--plugin", "pretty",
            "--plugin", "html:ft/reports/cucumber-report.html",
            "--glue", "com.generoso.ft.sd",
            "classpath:features"
        };

        io.cucumber.core.cli.Main.main(testArgs);
    }
}
