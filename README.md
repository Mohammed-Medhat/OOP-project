# OOP-project
Gym management systems provide fitness businesses the functionality to

manage schedules, memberships, and facilities.
The Gym management systems should keep track of these main entities.
1. GYM: (Name, Address, Phone number, Sports System.Equipments, List of coaches,
List of subscriptions).
2. Equipment: (Equipment name (such as treadmill, rowing machine, leg curl,
etc..), Equipment code, Quantity of this Equipment in the gym, and Equipment
photo (optional)).
3. User.Customer: (ID, Name, Gender, Address, Phone number, Email, subscription_plan.Subscription,
List of inbodies).
4. User.Coach: (ID, Name, Gender, Address, Phone number, Email, Working hours
per day (max 10 hours per day)).
5. subscription_plan.Subscription: the subscription entity keeps track of subscriptions of users.
Each subscription has (User.Customer ID, Assigned User.Coach ID, Membership Plan).
6. Membership plan: This entity should keep all details regarding the customer
plan such as (Start date, Monthly plan (3 days per week or 6 days per week),
number of months registered, price of the membership plan (discounts can
be applied when the number of months >=3)).
7. subscription_plan.InBody: This entity should keep all details regarding the customer health
metrics such as (date of subscription_plan.InBody, height (in m), total weight (in kg), body fat
mass (in kg), minerals (in kg), total body water (in kg), protein (in kg)).
