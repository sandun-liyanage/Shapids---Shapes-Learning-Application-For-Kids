import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.*;

import javax.swing.*;

import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.util.gl2.GLUT;

import java.awt.*;

public class ThreeDShape extends JPanel implements GLEventListener {
    private GLU glu = new GLU();
    private float rtri = 0.0f;
    private float rquad = 0.0f;
    private GLUT glut = new GLUT();
    static JFrame frame;

    @Override
    public void display(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();

        gl.glShadeModel(GL2.GL_SMOOTH);
        gl.glClearColor(0f, 0f, 0f, 0f);
        gl.glClearDepth(1.0f);
        gl.glEnable(GL2.GL_DEPTH_TEST);
        gl.glDepthFunc(GL2.GL_LEQUAL);
        gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST);
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();

        gl.glTranslatef(-2.0f, 0.0f, -6.0f);
        gl.glRotatef(rtri, 0.0f, 1.0f, 0.0f);

        // Draw Triangle
        gl.glBegin(GL2.GL_TRIANGLES);
        gl.glColor3f(0.5f, 0.5f, 1.0f); // Light Blue
        gl.glVertex3f(1.0f, 2.0f, 0.0f); // Top
        //gl.glColor3f(0.0f, 1.0f, 0.0f); // Green
        gl.glVertex3f(-1.0f, -1.0f, 1.0f); // Left
        //gl.glColor3f(0.0f, 0.0f, 1.0f); // Blue
        gl.glVertex3f(1.0f, -1.0f, 1.0f); // Right)

        //right
        gl.glColor3f(1.0f, 0.5f, 0.5f); // Light red
        gl.glVertex3f(1.0f, 2.0f, 0.0f); // Top
        //gl.glColor3f(0.0f, 0.0f, 1.0f);
        gl.glVertex3f(1.0f, -1.0f, 1.0f); // Left
        //gl.glColor3f(0.0f, 1.0f, 0.0f);
        gl.glVertex3f(1.0f, -1.0f, -1.0f); // Right

        //left
        gl.glColor3f(0.5f, 1.0f, 0.5f); // Light Green
        //gl.glColor3f(1.0f, 0.0f, 0.0f);
        gl.glVertex3f(1.0f, 2.0f, 0.0f); // Top
        //gl.glColor3f(0.0f, 1.0f, 0.0f);
        gl.glVertex3f(1.0f, -1.0f, -1.0f); // Left
        //gl.glColor3f(0.0f, 0.0f, 1.0f);
        gl.glVertex3f(-1.0f, -1.0f, -1.0f); // Right

        //top
        gl.glColor3f(1.0f, 1.0f, 0.5f); // Yellow
        //gl.glColor3f(0.0f, 1.0f, 0.0f);
        gl.glVertex3f(1.0f, 2.0f, 0.0f); // Top
        //gl.glColor3f(0.0f, 0.0f, 1.0f);
        gl.glVertex3f(-1.0f, -1.0f, -1.0f); // Left
        //gl.glColor3f(0.0f, 1.0f, 0.0f);
        gl.glVertex3f(-1.0f, -1.0f, 1.0f); // Right

        gl.glEnd(); // Done Drawing 3d  triangle (Pyramid)
        gl.glFlush();
        rtri += 0.2f;
        rquad -= 0.15f;


        gl.glLoadIdentity();


        gl.glTranslatef(2.5f, 0.0f, -6.0f);
        gl.glRotatef(rquad, 1.0f, 1.0f, 1.0f);

        // Draw Cube
        gl.glBegin(GL2.GL_QUADS);
        gl.glColor3f(0.5f, 0.5f, 1.0f); // Light Blue
        gl.glVertex3f(1.0f, 1.0f, -1.0f); // Top-right
        gl.glVertex3f(-1.0f, 1.0f, -1.0f); // Top-left
        gl.glVertex3f(-1.0f, 1.0f, 1.0f); // Bottom-left
        gl.glVertex3f(1.0f, 1.0f, 1.0f); // Bottom-right

        gl.glColor3f(1.0f, 0.5f, 0.5f); // Light Red
        gl.glVertex3f(1.0f, -1.0f, 1.0f); // Top-right
        gl.glVertex3f(-1.0f, -1.0f, 1.0f); // Top-left
        gl.glVertex3f(-1.0f, -1.0f, -1.0f); // Bottom-left
        gl.glVertex3f(1.0f, -1.0f, -1.0f); // Bottom-right

        gl.glColor3f(0.5f, 1.0f, 0.5f); // Light Green
        gl.glVertex3f(1.0f, 1.0f, 1.0f); // Top-right
        gl.glVertex3f(-1.0f, 1.0f, 1.0f); // Top-left
        gl.glVertex3f(-1.0f, -1.0f, 1.0f); // Bottom-left
        gl.glVertex3f(1.0f, -1.0f, 1.0f); // Bottom-right

        gl.glColor3f(0.5f, 0.5f, 0.5f); // Gray
        gl.glVertex3f(1.0f, -1.0f, -1.0f); // Top-right
        gl.glVertex3f(-1.0f, -1.0f, -1.0f); // Top-left
        gl.glVertex3f(-1.0f, 1.0f, -1.0f); // Bottom-left
        gl.glVertex3f(1.0f, 1.0f, -1.0f); // Bottom-right

        gl.glColor3f(1.0f, 1.0f, 0.5f); // Yellow
        gl.glVertex3f(-1.0f, 1.0f, 1.0f); // Top-right
        gl.glVertex3f(-1.0f, 1.0f, -1.0f); // Top-left
        gl.glVertex3f(-1.0f, -1.0f, -1.0f); // Bottom-left
        gl.glVertex3f(-1.0f, -1.0f, 1.0f); // Bottom-right

        gl.glColor3f(1.0f, 0.5f, 1.0f); // Purple
        gl.glVertex3f(1.0f, 1.0f, -1.0f); // Top-right
        gl.glVertex3f(1.0f, 1.0f, 1.0f); // Top-left
        gl.glVertex3f(1.0f, -1.0f, 1.0f); // Bottom-left
        gl.glVertex3f(1.0f, -1.0f, -1.0f); // Bottom-right
        gl.glEnd();

        gl.glFlush();
        rtri += 0.2f;
        rquad -= 0.15f;

        gl.glPushMatrix();
        gl.glLoadIdentity();

        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glPushMatrix();
        gl.glLoadIdentity();
        gl.glOrtho(0, drawable.getSurfaceWidth(), 0, drawable.getSurfaceHeight(), -1, 1);

        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glPushMatrix();
        gl.glLoadIdentity();

        gl.glColor3f(1.0f, 1.0f, 1.0f); // Set color to white

        Font font = new Font("Helvetica", Font.PLAIN, 30);
        FontMetrics fontMetrics = new Canvas().getFontMetrics(font);
        int labelWidth = fontMetrics.stringWidth("To be implemented");
        int labelHeight = fontMetrics.getHeight();


        int labelX = (drawable.getSurfaceWidth() - labelWidth) / 2; // Center the label horizontally
        int labelY = labelHeight; // Set the vertical position of the label

        gl.glRasterPos2f(labelX, labelY);

        glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18, "To be implemented"); // Render the label with the modified font size

        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glPopMatrix();
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glEnable(GL2.GL_DEPTH_TEST);
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
        // method body
    }

    @Override
    public void init(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
        gl.glShadeModel(GL2.GL_SMOOTH);
        gl.glClearColor(0f, 0f, 0f, 0f);
        gl.glClearDepth(1.0f);
        gl.glEnable(GL2.GL_DEPTH_TEST);
        gl.glDepthFunc(GL2.GL_LEQUAL);
        gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST);
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        final GL2 gl = drawable.getGL().getGL2();
        if (height <= 0)
            height = 1;
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    /*public ThreeDShape(){
        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);
        final GLCanvas glcanvas = new GLCanvas(capabilities);

        ThreeDShape combinedShapes = new ThreeDShape();
        glcanvas.addGLEventListener(combinedShapes);
        glcanvas.setSize(1400, 700);

        //frame = new JFrame("Combined 3D Shapes");

        NavBarLevel2 nb2 = new NavBarLevel2();
        nb2.getContentPane().add(glcanvas);

        //frame.setSize(1400, 800);
        //frame.setVisible(true);

        final FPSAnimator animator = new FPSAnimator(glcanvas, 300, true);
        animator.start();
    }*/

    public static void main(String[] args) {
        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);
        final GLCanvas glcanvas = new GLCanvas(capabilities);

        ThreeDShape combinedShapes = new ThreeDShape();
        glcanvas.addGLEventListener(combinedShapes);
        glcanvas.setSize(1400, 700);

        //frame = new JFrame("Combined 3D Shapes");

        NavBarLevel2 nb2 = new NavBarLevel2();
        nb2.getContentPane().add(glcanvas);

        //frame.setSize(1400, 800);
        //frame.setVisible(true);

        final FPSAnimator animator = new FPSAnimator(glcanvas, 300, true);
        animator.start();
    }
}
