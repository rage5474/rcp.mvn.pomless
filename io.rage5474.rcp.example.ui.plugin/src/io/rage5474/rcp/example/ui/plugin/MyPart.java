package io.rage5474.rcp.example.ui.plugin;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import io.rage5474.rcp.example.core.usecase.helloworld.api.HelloWorldCommandCallback;
import io.rage5474.rcp.example.core.usecase.helloworld.api.HelloWorldCommand;
import io.rage5474.rcp.example.core.usecase.helloworld.api.HelloWorldCommandFactory;

public class MyPart implements HelloWorldCommandCallback {

    private TableViewer viewer;

	private HelloWorldCommand helloWorldUseCase;
    
	@Inject 
    public MyPart(HelloWorldCommandFactory helloWorldUseCaseFactory) {
    	helloWorldUseCase = helloWorldUseCaseFactory.create(this);
	}
    
    @PostConstruct
    public void createPartControl(Composite parent) {
        viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL
                | SWT.V_SCROLL);
        viewer.setContentProvider(ArrayContentProvider.getInstance());
        TableViewerColumn column = new TableViewerColumn(viewer, SWT.NONE);
        column.getColumn().setWidth(100);
        column.setLabelProvider(new ColumnLabelProvider(){
            @Override
            public String getText(Object element) {
                return element.toString();
            }
        });

        helloWorldUseCase.sayHello("Raphael");
    }

    @Focus
    public void setFocus() {
        viewer.getControl().setFocus();
    }

	@Override
	public void helloWorldText(String text) {
		viewer.setInput(new String[] { text });
	}
} 
