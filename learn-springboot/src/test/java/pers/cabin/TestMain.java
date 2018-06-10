package pers.cabin;

import pers.cabin.common.utils.Result;

public class TestMain {

	public static void main(String[] args) {
		int code = (int) Result.ok().get("code");
		System.out.println(code);
	}

}
