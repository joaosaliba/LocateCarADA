package catalago.utils;

import java.util.Scanner;

public class ScannerSingleton {
    private Scanner scanner ;
    private static final ScannerSingleton SINGLETON = new ScannerSingleton();

    static{
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                ScannerSingleton.instance().getScanner().close();
            }
        });
    }
    private ScannerSingleton() {
        this.scanner= new Scanner(System.in);
    }

    public static ScannerSingleton instance() {
        return SINGLETON;
    }

    public Scanner getScanner() {
        return scanner;
    }
}
