import copy
import sys
#Global constants
grid_height=3
grid_width=3
goal_state=[[1,2,3],[4,0,5],[6,7,8]]
max_depth=20
class Total_Depth:
    def __init__(self,value):
        self.value=value
#class Goal_State_Exists:
 #   def __init__(self, exists):
  #      self.exists=exists

#Value for ending a recursion if the goal is found
class Goal_State:
    def __init__(self, found):
        #If the goal state is found
        self.found=found

#Value for the number of states enqueued
class States_Enqueued:
    def __init__(self, value):
        #No of states enqueued
        self.value=value


def is_goal_state(grid):
    return (grid==goal_state)



#Find the location of zero
def zero_location(grid):
    for r in range(len(grid)):
        for c in range(len(grid[r])):
            if(grid[r][c]==0):
                return [r,c]
class Search_Node:
    
    #Gives the number of displaced nodes from their original grid
    def heuristic1_val(self,grid):
        no_of_displaced_nodes=0
        for r in range(len(grid)):
            for c in range(len(grid[r])):
                #If a current value is displaced
                if(grid[r][c] != goal_state[r][c]):
                    no_of_displaced_nodes = no_of_displaced_nodes+1
        return no_of_displaced_nodes
    #Find the number of rows and columns a value has been displaced from its original position and then add them which becomes the displaced value
    #Add the displaced value for each number and the empty space and then return the value
    def heuristic2_val(self,grid):
        #Constant variable row 
        row=0
        #Constant variable column
        column=1
        total_displaced_amount=0
        for r in range(len(grid)):
            for c in range(len(grid[r])):
                #Location in the goal state of the given value
                goal_stt_loc=num_loc_goal_state(grid[r][c])
                #Amount displaced of the given value
                amount_displaced=abs(goal_stt_loc[row]-r)+abs(goal_stt_loc[column]-c)
                #Add the amount displaced to the total
                total_displaced_amount=total_displaced_amount+amount_displaced
    
        return total_displaced_amount
    def __init__(self,Previous, grid, previous_move, depth, is_solution):
        #Initialize the previous node
        self.Previous=Previous
        #The grid, zero is used for the empty location
        self.grid= grid
        #Up move node
        self.Up=None
        #Down move node
        self.Down= None
        #Left move node
        self.Left= None
        #Right move node
        self.Right= None
        #Previous move
        self.previous_move= previous_move
        #Current depth
        self.depth=depth
        #Whether it's the solution or not
        self.is_solution= is_solution
        #Heuristic1 value
        self.h1_value=self.heuristic1_val(grid)
        #Heuristic2 value
        self.h2_value=self.heuristic2_val(grid)
    

#Get the location of the empty location
def zero_location(grid):
    for r in range(len(grid)):
        for c in range(len(grid[r])):
            if(grid[r][c]==0):
                return [r,c]

def does_move_make_sense(grid,intended_move, previous_move):
    zero_loc=zero_location(grid)
    #Constant variable for zero location row 
    row=0
    #Constant variable for zero location column
    column=1

    
    #Dont revert to the previous state
    if intended_move=='u' and previous_move=='d':
        return False
    elif intended_move=='d' and previous_move=='u':
        return False
    elif intended_move=='l' and previous_move=='r':
        return False
    elif intended_move=='r' and previous_move=='l':
        return False


    #Check if it's out of bounds
    elif intended_move=='u' and (zero_loc[row]) == 0:
        return False
    elif intended_move=='d' and (zero_loc[row]) == grid_height-1:
        return False
    elif intended_move=='l' and (zero_loc[column]) == 0:
        return False
    elif intended_move=='r' and (zero_loc[column]) == grid_width-1:
        return False
    #Return true if move makes sense
    else:
        return True

#Swap the values based on the given move
def swap_values(grid, intended_move):
    zero_loc=zero_location(grid)
    #Constant variable for zero location row 
    row=0
    #Constant variable for zero location column
    column=1

    #Make a deep copy of the current grid
    new_grid=copy.deepcopy(grid)
    #Swap the values with the intended move
    if intended_move=='u':
        temp=new_grid[zero_loc[row]][zero_loc[column]]
        new_grid[zero_loc[row]][zero_loc[column]]=new_grid[zero_loc[row]-1][zero_loc[column]]
        new_grid[zero_loc[row]-1][zero_loc[column]]=temp
        
    elif intended_move=='d':
        temp=new_grid[zero_loc[row]][zero_loc[column]]
        new_grid[zero_loc[row]][zero_loc[column]]=new_grid[zero_loc[row]+1][zero_loc[column]]
        new_grid[zero_loc[row]+1][zero_loc[column]]=temp
        
    elif intended_move=='l':
        temp=new_grid[zero_loc[row]][zero_loc[column]]
        new_grid[zero_loc[row]][zero_loc[column]]=new_grid[zero_loc[row]][zero_loc[column]-1]
        new_grid[zero_loc[row]][zero_loc[column]-1]=temp
        
    elif intended_move=='r':
        temp=new_grid[zero_loc[row]][zero_loc[column]]
        new_grid[zero_loc[row]][zero_loc[column]]=new_grid[zero_loc[row]][zero_loc[column]+1]
        new_grid[zero_loc[row]][zero_loc[column]+1]=temp
    #print_grid(new_grid)
    return new_grid

def create_tree(Current_Node):
    #def __init__(self,Previous_Node, grid, previous_move, depth, Zero_loc, is_solution):
    if(Current_Node is None):
        return
    #print("----------------------------------")
    #print("Goal State")
    #print_grid(goal_state)
    #print("Previous")
    #if Current_Node.Pre    vious is not None:
    #    print_grid(Current_Node.Previous.grid)
    #print("Current")
    #print("Depth ",Current_Node.depth)
    #print(Current_Node.is_solution)
    #print_grid(Current_Node.grid)
    elif Current_Node.depth < max_depth:
        
        
        #Check if a move makes sense and then implement
        #Move the 
        if does_move_make_sense(Current_Node.grid, 'u', Current_Node.previous_move):
            new_grid=swap_values(Current_Node.grid, 'u')
            Current_Node.Up= Search_Node(Current_Node, new_grid,'u', Current_Node.depth + 1, is_goal_state(new_grid))

        if does_move_make_sense(Current_Node.grid, 'd', Current_Node.previous_move):
            new_grid=swap_values(Current_Node.grid, 'd')
            Current_Node.Down= Search_Node(Current_Node, new_grid, 'd', Current_Node.depth + 1, is_goal_state(new_grid))

        if does_move_make_sense(Current_Node.grid,'l', Current_Node.previous_move):
            new_grid=swap_values(Current_Node.grid, 'l')
            Current_Node.Left= Search_Node(Current_Node, new_grid,'l', Current_Node.depth + 1, is_goal_state(new_grid))
            
        if does_move_make_sense(Current_Node.grid,'r', Current_Node.previous_move):
            new_grid=swap_values(Current_Node.grid, 'r')
            Current_Node.Right= Search_Node(Current_Node, new_grid, 'r', Current_Node.depth + 1, is_goal_state(new_grid))
        create_tree(Current_Node.Up)
        create_tree(Current_Node.Down)
        create_tree(Current_Node.Left)
        create_tree(Current_Node.Right)
    else:
        return

#Print the given grid
def print_grid(grid):
    for r in range(len(grid)):
        for c in range(len(grid[r])):
            if grid[r][c] == 0:
               print('*  ',end='') 
            else:
                print(grid[r][c],' ',end='')
        print('\n')
    print("\n\n")

#Print the solution given the search implemented
def print_solution(search_type, Current_Node,Stts_Enqd):
    solution_list=[]
    Temp_Node=Current_Node
    #Create an array with the solution path
    while Temp_Node is not None:
        solution_list.insert(0, Temp_Node)
        Temp_Node=Temp_Node.Previous

    #Print the search type
    print(search_type)

    #Print the solution
    for Node in solution_list:
        print_grid(Node.grid)

    print("Number of moves ", len(solution_list))
    print("States enqueued ",Stts_Enqd.value)
        


#Depth first search which implements pre-order traversal
#Order will be root, up, down, left, right nodes respectively
def depth_first_search(Current_Node,Goal_Stt,Stts_Enqd):
    if Current_Node is not(None):
        #Increment the value which is passes by as reference since its a class
        Stts_Enqd.value =Stts_Enqd.value+1
        if not(Goal_Stt.found):
            #If the current node is the solution
            if Current_Node.is_solution:
                Goal_Stt.found=True
                print_solution("Depth First Search Solution",Current_Node,Stts_Enqd)
                return
        else:
            return

        #Search the "Up move" node
        depth_first_search(Current_Node.Up,Goal_Stt,Stts_Enqd)
        #Search the "Down move" node
        depth_first_search(Current_Node.Down,Goal_Stt,Stts_Enqd)
        #Search the "Left move" node
        depth_first_search(Current_Node.Left,Goal_Stt,Stts_Enqd)
        #Search the "Right move" node
        depth_first_search(Current_Node.Right,Goal_Stt,Stts_Enqd)
    else:
        return

def dfs(Current_Node):
    #Goal state exists is false until a goal state is found
    Goal_Stt= Goal_State(False)
    #Number of states enqueued
    Stts_Enqd=States_Enqueued(0)
    depth_first_search(Current_Node,Goal_Stt,Stts_Enqd)
    #If there is no goal state
    if not (Goal_Stt.found):
        print("Goal state is not reached within the depth of ",max_depth," for depth first search")

#Iterative deeping or depth first search which implements level order traversal
def iterative_deepening_search(Current_Node,Goal_Stt,Stts_Enqd):
    #The depth to be searched
    search_depth=0
    #Loops  through each depth value and searches the states
    while search_at_depth(Current_Node,Goal_Stt,Stts_Enqd,search_depth) and not(Goal_Stt.found):
        search_depth = search_depth + 1


#def search_at_depth(Current_Node,Goal_Stt,Stts_Enqd,depth):
    
def search_at_depth(Current_Node,Goal_Stt,Stts_Enqd,search_depth):
    #If the goal state has been found stop the recursion
    if not(Goal_Stt.found):
        #If there is no node
        if Current_Node is None:
            return False

    
        #Increment the value which is passes by as reference since its a class
        if search_depth==0:
            Stts_Enqd.value=Stts_Enqd.value+1
            if Current_Node.is_solution:
                Goal_Stt.found=True
                print_solution("Iterative deepening search Solution",Current_Node,Stts_Enqd)
            return True
        Up=search_at_depth(Current_Node.Up,Goal_Stt,Stts_Enqd,search_depth-1)
        Down=search_at_depth(Current_Node.Down,Goal_Stt,Stts_Enqd,search_depth-1)
        Left=search_at_depth(Current_Node.Left,Goal_Stt,Stts_Enqd,search_depth-1)
        Right=search_at_depth(Current_Node.Right,Goal_Stt,Stts_Enqd,search_depth-1)


        return Up or Down or Left or Right
            
#A* with heuristic 1
def astar1(Current_Node):
    #Goal state exists is false until a goal state is found
    Goal_Stt= Goal_State(False)
    #Number of states enqueued
    Stts_Enqd=States_Enqueued(0)
    astar1_search(Current_Node,Goal_Stt,Stts_Enqd)
    #If there is no goal state
    if not (Goal_Stt.found):
        print("Goal state is not reached within the depth of ",max_depth," for iterative A* search with heuristic value 1")


#A* with heuristic 1 search
def astar1_search(Current_Node,Goal_Stt,Stts_Enqd):
    if not(Goal_Stt.found):
        #If current node is none
        if Current_Node is (None):
            return
        #If the goal state has been found
        
        Stts_Enqd.value=Stts_Enqd.value+1
        if Current_Node.depth==10:
            return
        if Current_Node.is_solution:
            Goal_Stt.found=True
            print_solution("A* with heuristic 1 search Solution",Current_Node,Stts_Enqd)
            return
        #Create a priority list which will be sorted based on the heuristic value
        priority_list=[]
        if Current_Node.Up is not None:
            priority_list.append(Current_Node.Up)
        if Current_Node.Down is not None:
            priority_list.append(Current_Node.Down)
        if Current_Node.Left is not None:
            priority_list.append(Current_Node.Left)
        if Current_Node.Right is not None:
            priority_list.append(Current_Node.Right)
        #Bubble sort based on heuristic vale
        bubble_sort_h1(priority_list)
        #Traverse based on priority given in the heuristic value
        for Node in priority_list:
            if Node is not None:
                astar1_search(Node,Goal_Stt,Stts_Enqd)
    else:
        return
#A* with heuristic 2
def astar2(Current_Node):
    #Goal state exists is false until a goal state is found
    Goal_Stt= Goal_State(False)
    #Number of states enqueued
    Stts_Enqd=States_Enqueued(0)
    astar2_search(Current_Node,Goal_Stt,Stts_Enqd)
    #If there is no goal state
    if not (Goal_Stt.found):
        print("Goal state is not reached within the depth of ",max_depth," for iterative A* search with heuristic value 2")


#A* with heuristic 2 search
def astar2_search(Current_Node,Goal_Stt,Stts_Enqd):
    if not(Goal_Stt.found):
        #If current node is none
        if Current_Node is (None):
            return
        #If the goal state has been found
        
        Stts_Enqd.value=Stts_Enqd.value+1
        if Current_Node.depth==10:
            return
        if Current_Node.is_solution:
            Goal_Stt.found=True
            print_solution("A* with heuristic 2 search Solution",Current_Node,Stts_Enqd)
            return
        #Create a priority list which will be sorted based on the heuristic value
        priority_list=[]
        if Current_Node.Up is not None:
            priority_list.append(Current_Node.Up)
        if Current_Node.Down is not None:
            priority_list.append(Current_Node.Down)
        if Current_Node.Left is not None:
            priority_list.append(Current_Node.Left)
        if Current_Node.Right is not None:
            priority_list.append(Current_Node.Right)
        #Bubble sort based on heuristic vale
        bubble_sort_h2(priority_list)
        #Traverse based on priority given in the heuristic value
        for Node in priority_list:
            if Node is not None:
                astar2_search(Node,Goal_Stt,Stts_Enqd)
    else:
        return

#Get the location of given the value in the goal state
def num_loc_goal_state(value):
    for r in range(len(goal_state)):
        for c in range(len(goal_state[r])):
            if(goal_state[r][c]==value):
                return [r,c]        

#Bubble sort with h1 value
def bubble_sort_h1(priority_list):
    n=len(priority_list)
    #Go through array elements
    for i in range(n-1):
        # Last i elements are already in place
        for j in range(0, n-i-1):
            if priority_list[j].h1_value > priority_list[j + 1].h1_value :
                temp=priority_list[j]
                priority_list[j]=priority_list[j + 1]
                priority_list[j+1]=temp
                #priority_list[j], priority_list[j + 1] = priority_list[j + 1], priority_list[j]

#Bubble sort with h2 value
def bubble_sort_h2(priority_list):
    n=len(priority_list)
    #Go through array elements
    for i in range(n-1):
        # Last i elements are already in place
        for j in range(0, n-i-1):
            if priority_list[j].h2_value > priority_list[j + 1].h2_value :
                temp=priority_list[j]
                priority_list[j]=priority_list[j + 1]
                priority_list[j+1]=temp
                
    


#Search for the solution depending on the search type        
def search_solution(search_type,Root_Node):
    if search_type == "dfs":
        dfs(Root_Node)
    elif search_type == "ids":
        ids(Root_Node)
    elif search_type== "astar1":
        astar1(Root_Node)
    elif search_type== "astar2":
        astar2(Root_Node)
    else:
        print("Invalid search type")

#def astar2(Current_Node):
        



def ids(Current_Node):
    #Goal state exists is false until a goal state is found
    Goal_Stt= Goal_State(False)
    #Number of states enqueued
    Stts_Enqd=States_Enqueued(0)
    iterative_deepening_search(Current_Node,Goal_Stt,Stts_Enqd)
    #If there is no goal state
    if not (Goal_Stt.found):
        print("Goal state is not reached within the depth of ",max_depth," for iterative deepening search")


###Partition function for quicksort of heuristic1
##def partition_h1(priority_list, low, high):
##    # index of smaller element
##    i = (low-1)        
##    # pivot
##    pivot = priority_list[high].h1_value     
##  
##    for j in range(low, high):
##  
##        # If current element is smaller than or
##        # equal to pivot
##        if priority_list[j].h1_value <= pivot:
##  
##            # increment index of smaller element
##            i = i+1
##            priority_list[i], priority_list[j] = priority_list[j], priority_list[i]
##  
##    priority_list[i+1],  priority_list[high] =  priority_list[high],  priority_list[i+1]
##    return (i+1)
##
###Quick sort based on the heuristic 1 value
##def quick_sort_heuristic1(priority_list, low, high):
##    if len(priority_list) == 1:
##        return priority_list
##    if low < high:
##  
##        # pi is partitioning index, arr[p] is now
##        # at right place
##        pi = partition_h1(priority_list, low, high)
##  
##        # Separately sort elements before
##        # partition and after partition
##        quick_sort_heuristic1(priority_list, low, pi-1)
##        quick_sort_heuristic1(priority_list, pi+1, high)

    
def read_from_file(file_name):
    file = open(file_name, 'r')
    grid = [[0]*grid_width]*grid_height
    for r in range(len(grid)):
        for c in range(len(grid[r])):
            value=file.read(1)
            if value=='*':
                grid[r][c]=0
            else:
                grid[r][c]=value
    return grid

#filename="4365HW1Readfile.txt"
#init_grid=read_from_file(filename)
init_grid=[[2,3,5],[1,7,8],[4,0,6]]
#init_grid=read_from_file(file_name)
print("Initial grid")
print_grid(init_grid)
#print(does_move_make_sense('l', 'l', zero_location(grid))
#print("Down")
#swap_values(init_grid, 'd')
#print("Initial after swap")
#print_grid(init_grid)
#print("Up")
#swap_values(init_grid, 'r',)
#print(zero_location(init_grid))
#print(goal_state == init_grid)
Root_Node=Search_Node(None, init_grid, 'n', 0, is_goal_state(init_grid))
#print(Head_Node.init_grid)
#print(Head_Node.previous_move)

search_type=input("Enter search type ")
create_tree(Root_Node)

search_solution(search_type,Root_Node)


