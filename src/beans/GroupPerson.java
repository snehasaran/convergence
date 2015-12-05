package beans;

public class GroupPerson {
	private int groupId;
	private int personId;
	private String status;
	
	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	
	public void setGroupId(String groupId) {
		try {
			this.groupId = Integer.parseInt(groupId);
		}
		catch(NumberFormatException nfe) {
			nfe.printStackTrace();
		}
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}
	
	public void setPersonId(String personId) {
		try {
			this.groupId = Integer.parseInt(personId);
		}
		catch(NumberFormatException nfe) {
			nfe.printStackTrace();
		}
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
