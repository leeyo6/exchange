/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xsectionmesher;

/**
 *
 * @author leeyo
 */
public class element {
    int id,node1,node2,node3,node4;
    String type;
    
    private void element(){
        this.id = -1;
        this.type = "";
        this.node1 = -1;
        this.node2 = -1;
        this.node3 = -1;
        this.node4 = -1;
    }    
}
