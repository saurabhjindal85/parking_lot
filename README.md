# Parking Lot Application
Parking lot Application

#Pre-requistes
Java8 and Maven should be installed in machine

#Setup
goto bin folder and run './setup.sh <code_direcory>'

#Ways to run this project
1   ./parking_lot.sh <input_filepath>  
    The inputs commands are expected and taken from the file specified

2. ./parking_lot.sh 
   This will start the program in interactive mode
   The allowed inputs are 
   create_parking_lot <no_of_slots>
   park <reg_no> <color>
   leave <slot_number>
   status
   registration_numbers_for_cars_with_colour <colour>
   slot_numbers_for_cars_with_colour <colour>
   slot_number_for_registration_number <reg_no>
    
#run the testcases only
goto bin folder and run './run_functional_tests.sh <code_direcory>'
