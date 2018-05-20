package vlib_judge;

import static org.junit.Assert.*;

import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;
import org.junit.Test;

import vlib.util.GitUtil;

public class GitTest {

	@Test
	public void test() {
		try {
			GitUtil.cloneFromGitlab("https://github.com/gofmartin/Test.git", "D:/bishe/repo");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
