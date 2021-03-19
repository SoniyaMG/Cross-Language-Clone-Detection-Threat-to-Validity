# cook your dish here
#code_uncode create room
#asik 11-03-2021
a,b,c=map(int,input().strip().split())
box1=list(map(int,input().strip().split()))[:a]
box2=list(map(int,input().strip().split()))[:b]

box1=sorted(box1)

box2=sorted(box2)

prothom=0

ditio=0

gonona=0

while(prothom<a and ditio<b):
    choto = box1[prothom]-c
    boro = box1[prothom]+c
    if(choto<=box2[ditio] and box2[ditio]<=boro):
        
        gonona +=1
        prothom +=1
        ditio +=1
    elif(box2[ditio]<choto):
        
        ditio +=1
    else:
        
        prothom +=1

print(gonona)
