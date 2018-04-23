public class CustFile {
    protected String fileName;
    protected String fileType;
    protected String fileSize;

    public String getFileName() {
        return fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public String getFileSize() {
        return fileSize;
    }

    public Object[] getCustFile() {
        return new Object[] {fileName,fileType,fileSize};
    }

    public CustFile(String fileName, String fileType, String fileSize) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileSize = fileSize;
    }
}
