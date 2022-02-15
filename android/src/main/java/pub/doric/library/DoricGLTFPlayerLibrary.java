package pub.doric.library;

import java.io.IOException;
import java.io.InputStream;

import pub.doric.Doric;
import pub.doric.DoricComponent;
import pub.doric.DoricLibrary;
import pub.doric.DoricRegistry;

@DoricComponent
public class DoricGLTFPlayerLibrary extends DoricLibrary {
    @Override
    public void load(DoricRegistry registry) {
        try {
            InputStream is = Doric.application().getAssets().open("bundle_doric-gltf.js");
            byte[] bytes = new byte[is.available()];
            is.read(bytes);
            String content = new String(bytes);
            registry.registerJSBundle("doric-gltf", content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        registry.registerNativePlugin(DoricDemoPlugin.class);
        registry.registerViewNode(DoricGLTFNode.class);
    }
}
