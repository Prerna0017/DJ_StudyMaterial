data segment
    msg db "Enter a message: $"
ends 

code segment
    lea dx, msg
    mov ah, 09h
    int 21h

    mov ah, 01h
    int 21h

    mov dl,al
    mov ah, 02h
    int 21h

    mov ah, 4ch
    int 21h