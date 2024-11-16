package com.example.demo.constant;

/**
 *  enumクラス
*/

public class GoodsConstants {

	// FAN_TYPEを定義
	public enum FanType {
		NORMAL('0', "ノーマル会員"),
		REGULAR('1', "レギュラー会員"),
		GOLD('2', "ゴールド会員");
		
		private final int code;
		private final String description;
		
		FanType(char code, String description) {
			this.code = code;
			this.description = description;
		}
		
		public int getCode() {
			return code;
		}
		
		public String description() {
			return description;
		}
		
		public static FanType fromCode(int code) {
			// enum型FanTypeのすべての値を取得する
			for (FanType type : values()) {
				// 各FanTypeのコード（'0', '1', '2' など）と引数のcodeを比較
				if (type.code == code) {
					// 一致するFanTypeがあれば、それを返す
					return type;
				}
			}
			
			throw new IllegalArgumentException("そのコードは存在しません" + code);
		}
	}
	
	// COUNTER_HANDOVER_FRAGの定義
	public enum CounterHandoverFrag {
		UNDELIVERED('0', "未受け渡し"),
		DELEVERED('1', "受け取り済み");
		
		private final int code;
		private final String description;
		
		CounterHandoverFrag(int code, String description) {
			this.code = code;
			this.description = description;
		}
		
		public int getCode() {
			return code;
		}
		
		public String description() {
			return description;
		}
		
		public static CounterHandoverFrag fromcode(int code) {
			for (CounterHandoverFrag frag : values()) {
				if (frag.code == code) {
					return frag;
				}
			}
			throw new IllegalArgumentException("そのコードは存在しません" + code);	
		}
		
	}
	
}
