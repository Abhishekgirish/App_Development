package com.iamneo.security.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.iamneo.security.dto.request.FeedbackRequest;
import com.iamneo.security.dto.request.UserRequest;
import com.iamneo.security.entity.Feedback;
import com.iamneo.security.entity.FeedbackUser;
import com.iamneo.security.entity.User;
import com.iamneo.security.repository.FeedbackRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final FeedbackRepo uerRepository;
	
	private final RestTemplate restTemplate;

	public void addUserFeedback(UserRequest userRequest) {
		var user = FeedbackUser.builder().email(userRequest.getEmail()).build();
		var feedback = FeedbackRequest.builder().email(userRequest.getEmail()).rating(userRequest.getRating()).service(userRequest.getService()).feedback(userRequest.getFeedback()).build();
		uerRepository.save(user);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<FeedbackRequest> requestEntity = new HttpEntity<>(feedback, headers);
		restTemplate.postForObject("http://FEEDBACK-SERVICE/feed/addFeedback", requestEntity, FeedbackRequest.class);
	}
}