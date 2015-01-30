package example.controller;

import example.service.GitHubService;
import example.service.GitHubUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/github/user")
public class GitHubUserController {
	private GitHubService gitHubService;

	@Autowired
	public GitHubUserController(GitHubService gitHubService) {
		this.gitHubService = gitHubService;
	}

	@RequestMapping(value = "/{username}")
	@ResponseBody
	public GitHubUser getGitHubUser(@PathVariable(value = "username") String username) {
		return gitHubService.getUser(username);
	}

}
