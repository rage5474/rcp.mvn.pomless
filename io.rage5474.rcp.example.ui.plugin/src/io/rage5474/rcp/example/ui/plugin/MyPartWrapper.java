package io.rage5474.rcp.example.ui.plugin;

import org.eclipse.e4.tools.compat.parts.DIViewPart;

@SuppressWarnings("restriction")
public class MyPartWrapper extends DIViewPart<MyPart> {

	public MyPartWrapper() {
		super(MyPart.class);
	}
	
}