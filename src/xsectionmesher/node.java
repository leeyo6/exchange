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
public class node {
    int id;
    double x,y,z;

    private void node(){
        this.id = -1;
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
    }
}
