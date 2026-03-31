package download_manager;

class FileDownloader extends Thread {
    private String fileName;

    FileDownloader(String fileName) {
        this.fileName = fileName;
    }

    public void run() {
        for(int i = 0; i <= 100; i += 25) {
            System.out.println("[" + Thread.currentThread().getName() +
                    "] Downloading " + fileName + ": " + i + "%");
            try {
                Thread.sleep((int) (Math.random() * 500));
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class DownloadManagerThread {
    public static void main(String[] args) throws InterruptedException {
        FileDownloader d1 = new FileDownloader("Document.pdf");
        FileDownloader d2 = new FileDownloader("Image.jpg");
        FileDownloader d3 = new FileDownloader("Video.mp4");
        d1.start();
        d2.start();
        d3.start();
        d1.join();
        d2.join();
        d3.join();
        System.out.println("All downloads complete!");
    }
}
