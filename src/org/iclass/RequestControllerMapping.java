package org.iclass;

import java.util.HashMap;
import java.util.Map;

import org.iclass.controller.Controller;
import org.iclass.controller.MemberJoinController;
import org.iclass.controller.MemberListController;
import org.iclass.controller.ShopIndexController;

public class RequestControllerMapping {
//처리해야 할 RequestKeyValue와 처리할 Controller 구현체 클래스 지정하기(매핑)
	//Map<Key,Value> : Key를 이용해서 Value를 가져오기
	private static final Map<RequestKeyValue,Controller> mapping = new HashMap<>();
	
	//매핑 설정
	public static void init() {
		mapping.put(new RequestKeyValue("/","GET"),new ShopIndexController());
		mapping.put(new RequestKeyValue("/index","GET"),new ShopIndexController());
		mapping.put(new RequestKeyValue("/member/list","GET"),new MemberListController());
		mapping.put(new RequestKeyValue("/member/join","GET"),new MemberJoinController());
	}
	
	public static Controller getController(RequestKeyValue key) {
		return mapping.get(key);
	}
	
}
