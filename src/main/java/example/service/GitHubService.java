package example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GitHubService {
	private static RestTemplate restTemplate;
	private String gitHubUserApiUrl;

	static {
		restTemplate = new RestTemplate();
	}

	@Autowired
	public GitHubService(String gitHubUserApiUrl) {
		this.gitHubUserApiUrl = gitHubUserApiUrl;
	}

	public GitHubUser getUser(String username) {
		String url = gitHubUserApiUrl + username;
		return restTemplate.getForObject(url, GitHubUser.class);
	}

}
