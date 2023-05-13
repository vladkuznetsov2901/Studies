mov ax, 0FFFFh 
mov bx, 1h
add ax,bx
mov ax,0FF00h
add ax,bx
adc bx,ax
mov ax,0FFFFh
mov bx,1h    
add ax,bx 
adc bx,ax
mov ax,0FFFFh
mov bx,1h
add ax,bx 
sbb bx,ax
