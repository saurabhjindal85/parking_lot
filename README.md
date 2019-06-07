# Parking Lot Application
Parking lot Application

# Pre-requistes
Java8 and Maven should be installed in machine

# Setup
goto bin folder and run './setup.sh <code_direcory>'<br />
**example** ./parking_lot.sh C:\Saurabh\Workspace\drawningCanvas\parking_lot\

# Ways to run this project

1  ./parking_lot.sh <input_filepath> <br />

    **example** ./parking_lot.sh C:\Saurabh\Workspace\drawningCanvas\parking_lot\Test_commands.txt<br/>
    The inputs commands are expected and taken from the file specified <br />

2. ./parking_lot.sh <br />
   This will start the program in interactive mode <br />
   The allowed inputs are <br />
    create_parking_lot 6 <br />
    park MH14-DW-3493 White <br />
    park MH14-DW-002 White <br />
    park MH14-DW-003 Black <br />
    park MH14-DW-004 Red <br />
    park MH14-DW-005 Blue <br />
    park MH14-DW-006 Black <br />
    status <br />
    slot_numbers_for_cars_with_colour White <br />
    
# run the testcases only

goto bin folder and run './run_functional_tests.sh <code_direcory>'
**example** ./parking_lot.sh C:\Saurabh\Workspace\drawningCanvas\parking_lot\
