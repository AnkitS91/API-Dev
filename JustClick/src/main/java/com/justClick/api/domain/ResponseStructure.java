package com.justClick.api.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonSerialize
@JsonInclude(Include.NON_NULL)
public class ResponseStructure {
	
	private Posts[] posts;

    private Comments[] comments;

    private Profile profile;

	

}
