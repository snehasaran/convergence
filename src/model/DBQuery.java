package model;


public interface DBQuery {

		//public static final String SELECT_SQL = "SELECT * FROM Employee2_527556";

		public static final String INSERT_SQL_USER = "Insert into person"

				+ "(person_id, first_name, last_name ,user_city , phone_id,  user_gender, user_state, user_age, user_email) values"

				+ "(?,?,?,?,?,?,?,?)";

		//public static final String INSERT_SQL_LANG = "Insert into language2_527556 "

			//+ "(lang_ID,lang_Name)values" + "(?,?)";

		//public static final String INSERT_SQL_TECH = "Insert into technologies2_527556 "

			//	+ "(tech_ID,tech_Name )values" + "(?,?)";

		//public static final String INSERT_SQL_EMP_LANG = "Insert into Employee2_Lang_527556 "

			//	+ "(Empl_emp_ID,Lang_ID )values" + "(?,?)";

		//public static final String INSERT_SQL_EMP_TECH = "Insert into Employee2_tech_527556 "

			//	+ "(Empt_emp_ID ,Empt_tech_ID )values" + "(?,?)";

		//public static final String DELETE_SQL_EMP = "Delete FROM Employee2_527556 where Emp_ID = ?";

		//public static final String DELETE_SQL_EMP_LANG = "Delete FROM Employee2_Lang_527556 where EMPL_Emp_Id=? ";

		//public static final String DELETE_SQL_EMP_TECH = "Delete FROM Employee2_tech_527556 where EMPT_Emp_Id=? ";

		//public static final String GET_LANGUAGE_ID = "SELECT Lang_id FROM Language2_527556 WHERE Lang_name = ?";

		//public static final String GET_TECHNOLOGY_ID = "SELECT tech_id FROM technologies2_527556 WHERE tech_name = ?";

		//public static final String GET_EMP_LANGUAGES = "SELECT lang_name "
		//		+ "from language2_527556 where lang_id IN "
		//		+ "(select lang_id FROM employee2_lang_527556 where empl_emp_id = ?)";

		//public static final String GET_EMP_TECHNOLOGIES = "select tech_name "
//				+ "from technologies2_527556 where tech_id IN "
				//+ "(select empt_tech_id FROM employee2_tech_527556 where empt_emp_id = ?)";
	}

