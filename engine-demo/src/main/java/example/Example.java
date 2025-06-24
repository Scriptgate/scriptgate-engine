package example;

import net.scriptgate.common.Color3f;
import net.scriptgate.common.Point;
import net.scriptgate.engine.Application;
import net.scriptgate.engine.Engine;
import net.scriptgate.engine.InputComponent;
import net.scriptgate.engine.Renderer;
import net.scriptgate.engine.lwjgl.OpenGLApplicationHandler;

import static net.scriptgate.common.Color3f.BLUE;
import static net.scriptgate.common.Color3f.WHITE;

public class Example implements Application {

    public static void main(String[] args) throws Exception {
        new OpenGLApplicationHandler().start(new Example());
    }

    private int fps = 0;
    private float ballAngle = 0;
    private static final int RADIUS = 30;

    @Override
    public void onUpdate(int ticks, int frames) {
        fps = frames;
    }

    @Override
    public void onTick(InputComponent inputComponent, double elapsedTime) {
        ballAngle += 0.1f;
    }

    @Override
    public void render(Renderer renderer) {
        renderer.setColor(WHITE);
        renderer.drawText(50, 50, "FPS: " + fps);

        Point ballPosition = getBallCurrentPosition();

        renderer.setColor(BLUE);
        renderer.fillCircle(ballPosition.x, ballPosition.y, RADIUS);
        renderer.setColor(WHITE);
        renderer.drawCircle(ballPosition.x, ballPosition.y, RADIUS);
    }

    private Point getBallCurrentPosition() {
        int x = (int) (Engine.WIDTH / 2 + Math.cos(ballAngle) * RADIUS * 2);
        int y = (int) (Engine.HEIGHT / 2 + Math.sin(ballAngle) * RADIUS * 2);

        return new Point(x, y);
    }
}
