package vlib.util;

import java.io.File;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;

public class GitUtil {
	
	public static void cloneFromGitlab(String url, String repopath) throws InvalidRemoteException, TransportException, GitAPIException {
		Git git = Git.cloneRepository()
				  .setURI(url)
				  .setDirectory(new File(repopath))
				  .call();
		git.close();
	}
	
	public static void delDir(File f) {
	    // 判断是否是一个目录, 不是的话跳过, 直接删除; 如果是一个目录, 先将其内容清空.
	    if(f.isDirectory()) {
	        // 获取子文件/目录
	        File[] subFiles = f.listFiles();
	        // 遍历该目录
	        for (File subFile : subFiles) {
	            // 递归调用删除该文件: 如果这是一个空目录或文件, 一次递归就可删除. 如果这是一个非空目录, 多次
	            // 递归清空其内容后再删除
	            delDir(subFile);
	        }
	    }
	    // 删除空目录或文件
	    f.delete();
	}
	
	public static String getRepoName(String url) {
		String[] strs1 = url.split("/");
		String repo = strs1[strs1.length-1];
		String[] strs2 = repo.split("\\.");
		return strs2[0];
	}
	
}
