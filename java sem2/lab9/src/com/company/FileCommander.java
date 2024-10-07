package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileCommander {
    private Path path;

    public FileCommander() {
        this.path = Path.of(System.getProperty("user.home"));
    }
    public String pwd() {
        return path.toString();
    }
    public void cd(String path) {
        this.path = this.path.resolve(path);
    }
    public List<String> ls ()
    {
       /* 1. File dir=path.toFile();
        List<File> lf= Arrays.asList(dir.listFiles());
        List<String> result= new ArrayList<>();
        for(File file:lf)
        {
            result.add(file.getName());
        }

        return  result;*/
       /*  2. File [] dir= new  File(path.toString()).listFiles();
        List<String> result= new ArrayList<>();
        Stream<File> fileStream= Stream.of(dir);
        Stream<String> stringStream= fileStream.map(File::getName);
        result=stringStream.collect(Collectors.toList());
        return result;*/
        Comparator<Path> pathComparator=(p1,p2)-> Boolean.compare(Files.isDirectory(p2),Files.isDirectory(p1) );
        pathComparator.thenComparing(p->p.getFileName().toString());
        try {
            Stream<Path> pathStream = Files.list(path);
            return pathStream
                    .sorted(pathComparator)
                    //.map(Path::getFileName)
                    .map(path1 -> {String s=path1.getFileName().toString();
                    if(Files.isDirectory(path1)){
                        s="["+s+"]";
                        return s;}
                    else return s;

                    })
                    //.map(Path::toString)
                    //.sorted()
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
    public List<String> find(String findString)
    {
        try {
            Stream<Path> pathStream=Files.walk(path);
            return pathStream
                    .filter(k->k.getFileName().toString().contains(findString))
                    .map(Path::toString)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
    public File archive (List<String> list)
    {
        try {
            File result= File.createTempFile("archive",".zip");
            FileOutputStream stream= new FileOutputStream(result);
            ZipOutputStream zipOutputStream= new ZipOutputStream(stream);
            for(String file:list)
            {
                FileInputStream fi = new FileInputStream(String.valueOf(path.resolve(file)));
                ZipEntry ze = new ZipEntry(Paths.get(file).getFileName().toString());
                zipOutputStream.putNextEntry(ze);
                byte[] buf= new  byte[1024];
                int len;
                while ((len=fi.read(buf))>=0)
                {
                    zipOutputStream.write(buf,0,len);
                }
                fi.close();
            }
            stream.close();
            zipOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
        return null;

    }
}
