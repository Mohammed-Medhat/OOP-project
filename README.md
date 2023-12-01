# OOP-project
Gym management systems provide fitness businesses the functionality to

manage schedules, memberships, and facilities.
The Gym management systems should keep track of these main entities.
1. GYM: (Name, Address, Phone number, Sports Equipments, List of coaches,
List of subscriptions).
2. Equipment: (Equipment name (such as treadmill, rowing machine, leg curl,
etc..), Equipment code, Quantity of this Equipment in the gym, and Equipment
photo (optional)).
3. Customer: (ID, Name, Gender, Address, Phone number, Email, Subscription,
List of inbodies).
4. Coach: (ID, Name, Gender, Address, Phone number, Email, Working hours
per day (max 10 hours per day)).
5. Subscription: the subscription entity keeps track of subscriptions of users.
Each subscription has (Customer ID, Assigned Coach ID, Membership Plan).
6. Membership plan: This entity should keep all details regarding the customer
plan such as (Start date, Monthly plan (3 days per week or 6 days per week),
number of months registered, price of the membership plan (discounts can
be applied when the number of months >=3)).
7. InBody: This entity should keep all details regarding the customer health
metrics such as (date of InBody, height (in m), total weight (in kg), body fat
mass (in kg), minerals (in kg), total body water (in kg), protein (in kg)).
