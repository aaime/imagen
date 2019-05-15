/**
 /*
 * Copyright (c) 2019, Oracle and/or its affiliates. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package org.eclipse.imagen.tutorial.network;

import java.awt.*;
import java.util.Vector;
import org.eclipse.imagen.*;
import org.eclipse.imagen.remote.RemoteJAI;
import javax.swing.*;
import java.awt.image.SampleModel;

public abstract class JAIDyadicPanel extends JAIDemoPanel {
  
    JAINetworkDemo demo;
    
    public JAIDyadicPanel(JAINetworkDemo demo, 
			  Vector sourceVec, 
			  RemoteJAI pClient) {
        super(sourceVec, pClient);
        this.demo = demo;
	this.client = pClient;
        masterSetup();
    }  
    
    public void makeControls(JPanel controls) {
    }
    
    public RenderingHints getRenderingHints(int dType,
                                            Rectangle rect,
                                            int nBands) {
        SampleModel sm =
            RasterFactory.createPixelInterleavedSampleModel(dType,
                                                            rect.width,
                                                            rect.height,
                                                            nBands);
        
        ImageLayout il = new ImageLayout();
        il.setSampleModel(sm);
        return new RenderingHints(JAI.KEY_IMAGE_LAYOUT, il);
    }
    
    public void reset() {
        demo.resetAdj();
    }
}