data segment
a dw 10
b dw 20
c dw 5
x dw ?
data ends
code segment
assume cs: code, ds: data
start: mov ax, data
mov ds, ax 		 
mov ax, a
mov bx, b
mov dx, b
mov cx, c
sal ax, 1
sal bx, 2
add ax, cx
add ax, bx
add ax, dx
neg ax
mov x, ax 		
quit:
mov ax, 4c00h 	
int 21 			
code ends
end start
