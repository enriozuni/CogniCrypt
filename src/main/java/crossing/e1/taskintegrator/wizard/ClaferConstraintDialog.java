package crossing.e1.taskintegrator.wizard;

import java.util.ArrayList;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;


public class ClaferConstraintDialog extends Dialog {

	private Text text;
	private String constraintString;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 * @wbp.parser.constructor
	 */
	public ClaferConstraintDialog(Shell parentShell) {
		super(parentShell);
		setShellStyle(SWT.CLOSE | SWT.MAX | SWT.RESIZE | SWT.TITLE);
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		GridLayout gl_container = new GridLayout(1, false);
		container.setLayout(gl_container);

		getShell().setMinimumSize(600, 400);

		ListViewer listViewer = new ListViewer(container, SWT.BORDER | SWT.V_SCROLL);
		List list = listViewer.getList();

		GridData gd_list = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_list.heightHint = 340;
		gd_list.grabExcessHorizontalSpace = true;
		list.setLayoutData(gd_list);

		Group group = new Group(container, SWT.NONE);
		group.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		RowLayout rl_group = new RowLayout(SWT.HORIZONTAL);
		group.setLayout(rl_group);

		ArrayList<String> buttonTexts = new ArrayList<>();
		buttonTexts.add(" NOT ");
		buttonTexts.add(" EQUALS ");
		buttonTexts.add(" AND ");
		buttonTexts.add(" OR ");
		buttonTexts.add(" implies ");
		buttonTexts.add(" ( ");
		buttonTexts.add(" ) ");
		buttonTexts.add(" > ");
		buttonTexts.add(" < ");

		for (String btnText : buttonTexts) {
			Button newButton = new Button(group, SWT.PUSH);
			newButton.setText(btnText);
			newButton.addListener(SWT.Selection, new Listener() {

				@Override
				public void handleEvent(Event arg0) {
					text.insert(btnText);

				}
			});
		}

		text = new Text(container, SWT.BORDER | SWT.WRAP);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

		return container;
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(600, 600);
	}

	@Override
	protected void okPressed() {
		constraintString = text.getText();
		super.okPressed();
	}

	public String getResult() {
		return constraintString;
	}

}