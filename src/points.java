import javax.media.j3d.Appearance;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.GeometryArray;
import javax.media.j3d.LineStripArray;
import javax.media.j3d.Shape3D;
import javax.vecmath.Point3d;
import com.sun.j3d.utils.universe.SimpleUniverse;


public class points {

    public points(){

    SimpleUniverse u=new SimpleUniverse(); 

    BranchGroup group=new BranchGroup();

    Point3d coords[] = new Point3d[4];

Appearance app=new Appearance();

     coords[0] = new Point3d(-0.5d, -0.2d, 0.1d);
     coords[1] = new Point3d(-0.2d, 0.1d, 0.0d);
     coords[2] = new Point3d(0.2d, -0.3d, 0.1d);
     coords[3] = new Point3d(-0.5d, -0.2d, 0.1d);

     int vertexCounts[] = {4};

     LineStripArray lines = new LineStripArray(4,
     GeometryArray.COORDINATES, vertexCounts);

     lines.setCoordinates(0, coords);

    Shape3D shape=new Shape3D(lines , app);

    group.addChild(shape);

    u.addBranchGraph(group);

    u.getViewingPlatform().setNominalViewingTransform();

    }

    public static void main(String[] args) {

        // TODO Auto-generated method stub

        new points();
    }
}

