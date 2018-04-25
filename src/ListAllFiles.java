import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ListAllFiles {
    public ArrayList<CustFile> listFile(String args)throws IOException {
        ArrayList<CustFile> result = new ArrayList<>();
        Files.list(Paths.get(args))
                .filter(Files::isDirectory)
                .forEach(path -> {
                    if(Files.exists(path)) {
                        String filename = path.toString();
                        int s = filename.lastIndexOf('\\');
                        filename=filename.substring(s+1,filename.length());

                        try{
                            double x = Files.size(path);
                            String unit = "B";
                            if(x>1024){
                                x=x/1024;
                                unit = "KB";
                            }
                            if(x>1024){
                                x=x/1024;
                                unit = "MB";
                            }
                            if(x>1024){
                                x=x/1024;
                                unit = "GB";
                            }
                            result.add(new CustFile(filename,"Folder",Math.round(x)+" "+unit));
                        }
                        catch(IOException e){
                            System.err.print(e.getMessage());
                        }
                    }
                });
        Files.list(Paths.get(args))
                .filter(Files::isRegularFile)
                .forEach(path -> {
                    String filename = path.toString();
                    int s = filename.lastIndexOf('\\');
                    filename=filename.substring(s+1,filename.length());

                    try{
                        double x = Files.size(path);
                        String unit = "B";
                        if(x>1024){
                            x=x/1024;
                            unit = "KB";
                        }
                        if(x>1024){
                            x=x/1024;
                            unit = "MB";
                        }
                        if(x>1024){
                            x=x/1024;
                            unit = "GB";
                        }
                        result.add(new CustFile(filename,"File",Math.round(x)+" "+unit));
                    }
                    catch(IOException e){
                        System.err.print(e.getMessage());
                    }
                });
        return result;
    }
}
