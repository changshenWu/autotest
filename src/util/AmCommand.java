package util;

import java.io.File;

import util.CmdOptionsConst.Am;

public class AmCommand implements IAdbCommand {

	private AdbCmdRecevier acr = null;

	@Override
	public void run(String args) {
		acr = new AdbCmdRecevier();
		if (Am.STOP.equals(args)) {
			acr.runAmStop();
		} else if(Am.TEL.equals(args)) {
			acr.runAmStartPhone();
		}else if (Am.WEB.equals(args)) {
			acr.runAmStartWebView();
		}
	}

	@Override
	public File getCmdResultFile() {
		if (acr != null) {
			return acr.getCmdResultFile();
		} else {
			Logger.log("尚未执行相关命令!");
			return null;
		}
	}

}
