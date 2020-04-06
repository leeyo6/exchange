package xsectionmesher;

import com.sun.j3d.utils.universe.SimpleUniverse;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.BranchGroup;
import com.sun.j3d.utils.geometry.ColorCube;
import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.j3d.Appearance;
import javax.media.j3d.GeometryArray;
import javax.media.j3d.LineStripArray;
import javax.media.j3d.Shape3D;
import javax.media.j3d.VirtualUniverse;
import javax.swing.JPanel;
import javax.vecmath.Point3d;

public class JPanel3D extends JPanel{

    public SimpleUniverse universe;
    public BranchGroup branchGroup;
  public JPanel3D(){//constructor
    setLayout(new BorderLayout());

    //Create a Canvas3D object to be used for rendering the
    // Java 3D universe.  Place it in the CENTER of the
    // Frame.
    Canvas3D canvas = new Canvas3D(
               SimpleUniverse.getPreferredConfiguration());
    add(BorderLayout.CENTER,canvas);

    //Create a pair of Label objects to serve as
    // placeholders.  Position them in the NORTH and SOUTH
    // locations in the window.
    add(BorderLayout.NORTH,new Label(
                        "Label object in NORTH location"));
    add(BorderLayout.SOUTH, new Label(
                        "Label object in SOUTH location"));

    //Create an empty Java 3D universe and associate it 
    // with the Canvas3D object in the CENTER of the
    // Frame.
    universe = new SimpleUniverse(canvas);

    //Set the apparent position of the viewer's eye.
    universe.getViewingPlatform().
                              setNominalViewingTransform();

    //Put a visible object in the universe
    branchGroup = new BranchGroup();
    
    

    //This listener is used to terminate the program when
    // the user clicks the X in the upper-right corner of
    // the Frame.
    addWindowListener(
      new WindowAdapter(){
        public void windowClosing(WindowEvent e){
          System.exit(0);
        }//end windowClosing
      }//end new WindowAdapter
    );//end addWindowListener
  }//end constructor
  //-----------------------------------------------------//

    public void plotData(Point3d coords[]) {
        Shape3D shape = plotLines(coords);
        //branchGroup.addChild(new ColorCube(0.2));\
        branchGroup.removeAllChildren();
        branchGroup.addChild(shape);

        universe.addBranchGraph(branchGroup);

        //Set the Frame size and title and make it all visible.
        //setSize(475, 475);
        //setTitle("Copyright 2007, R.G.Baldwin");
        setVisible(true);
    }
  public Shape3D plotLines(Point3d coords[]){
      //Point3d coords[] = new Point3d[4];

      Appearance app=new Appearance();

       // coords[0] = new Point3d(-0.5d, -0.2d, 0.1d);
       // coords[1] = new Point3d(-0.2d, 0.1d, 0.0d);
       // coords[2] = new Point3d(0.2d, -0.3d, 0.1d);
       // coords[3] = new Point3d(-0.5d, -0.2d, 0.1d);

        int vertexCounts[] = {4};

        LineStripArray lines = new LineStripArray(4,
        GeometryArray.COORDINATES, vertexCounts);

        lines.setCoordinates(0, coords);

       Shape3D shape=new Shape3D(lines , app);
       return shape;
     }
  
  public static void main(String[] args){
    JPanel3D thisObj = new JPanel3D();
  }//end main
  //-----------------------------------------------------//

}//end class Java3D003
