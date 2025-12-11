package com.pplip.domain.trip.attraction.persistence.entity;

import lombok.Getter;

import java.util.stream.Stream;

@Getter
public enum ContentType {
	ATTRACTION(12, "관광지"),
	CULTURAL_FACILITIES(14, "문화시설"),
	FESTIVAL_PERFORMANCE_EVENT(15, "행사"),
	TRAVEL_COURSE(25, "관광코스"),
	LEPORTS(28, "레포츠"),
	ACCOMMODATION(32, "숙박"),
	SHOPPING(38, "쇼핑"),
	RESTAURANT(39, "음식점");

	private final int id;
	private final String description;

	ContentType(int id, String description) {
		this.id = id;
		this.description = description;
	}

	public static ContentType getContentType(int id) {
		for (ContentType type : ContentType.values()) {
			if (type.getId() == id) {
				return type;
			}
		}
		System.out.println("매칭되는 숫자가 없습니다: " + id);
		return null;
	}

	public static ContentType getContentType(String desc) {
		return Stream.of(ContentType.values()).filter(v -> v.description.equals(desc)).findFirst().get();
	}

}
