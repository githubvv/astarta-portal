package astarta.db.enumeration;

public enum UserGroup {

	ADMIN {
		public Long getGroupId() {
			return 1L;
		}
	},
	USER {
		public Long getGroupId() {
			return 2L;
		}
	};
	public abstract Long getGroupId();

}
