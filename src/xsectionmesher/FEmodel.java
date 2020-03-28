/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xsectionmesher;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import xsectionmesher.node;
import xsectionmesher.element;
import java.util.HashMap;
import java.util.stream.Stream;

/**
 *
 * @author leeyo
 */
public class FEmodel {
    private int rid;
    private double rx;
    private double ry;
    private double rz;     
    HashMap<Integer, ArrayList> nodeMap;
    HashMap<Integer, ArrayList> elementMap;
    ArrayList<Double> nXYZ = new ArrayList<>();
    ArrayList<Integer> eNodes = new ArrayList<>();
    
    public void FEmodel(){
        nodeMap = new HashMap<Integer, ArrayList>(); 
        elementMap = new HashMap<Integer, ArrayList>(); 
    }
    
    
    public void addNode(int idi,double xi,double yi, double zi){
        nXYZ.add(0,xi);
        nXYZ.add(1,yi);
        nXYZ.add(2,zi);
        nodeMap.put((Integer) idi, nXYZ);
    }
    
    public Object getNode(int idi){
        return nodeMap.get(idi);
    }
    
    public void addElement(int idi,int n1,int n2, int n3,int n4){
        eNodes.add(0,n1);
        eNodes.add(1,n2);
        eNodes.add(2,n3);
        eNodes.add(3,n4);
        elementMap.put((Integer) idi, eNodes);
    }
    
    public Object getElement(int idi){
        return elementMap.get(idi);
    }
    
    public void parseBDF(String fPath){
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines( Paths.get(fPath), StandardCharsets.UTF_8)) 
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }

    }
}


