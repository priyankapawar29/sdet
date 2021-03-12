@HRM_activity
Feature: Application OrangeHRM

@HRMactivity1
Scenario: Creating a job vacancy
			Given Open the browser
			When Login OrangeHRM page
			Then Navigate to Recruitment page
			And Click on Vacancies and navigate to vacancies page
			And Click on Add button and navigate to Add Job Vacancy form
			And Fill necessary details and save
			And Verify vacancy has been created
			And Close FF browser
			
@HRMactivity2
Scenario: Adding a candidate for recruitment
      Given Open the browser
			When Login OrangeHRM page
			Then Navigate to Recruitment page
			And Click on candidate button and add button
			And Fill all the details, upload resume and save
			And Verify candidate has been added
			And Close FF browser
		
@HRMactivity3
Scenario Outline: Add multiple employees
          Given Open the browser
          When Login OrangeHRM page
          Then Navigate PIM page
          And Click add button to add employee
          And Check Create Login Details checkbox
          And Enter "<FirstName>" and "<LastName>" and "<UserName>" save
          And Verify employee have been added
          And Close FF browser
      
Examples:
| FirstName | LastName         | UserName |
| Vaishnavi | Kutella          | SG120    |
| Amrutha   | Venkatesh        | AV908    |
| Kaveri    | Kumari           | KK891    |
| Arun      | Bhardwaj         | AB145    |

@HRMactivity4
Scenario Outline: Creating multiple vacancies
      Given Open the browser
			When Login OrangeHRM page
			Then Navigate to Recruitment page
			And Click on Vacancies and navigate to vacancies page
			And Click on Add button and navigate to Add Job Vacancy form
			Then User select "<JobTitle>" and "<VacancyName>" and "<HiringManager>" save
			And Verify all the vacancies have been created
			And Close FF browser
			
Examples:
| JobTitle          | VacancyName | HiringManager |
| Android Developer | SDET Tester1878 | orange hrm    |
| Automation Test Engineer | SDET Tester9079 | orange hrm |
| DevOps Engineer | SDET Tester9080 | orange hrm |
| Java Developer | SDET Tester9081 | orange hrm |
| Rust Engineer | SDET Tester9082 | orange hrm |
