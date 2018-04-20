import cv2

# importing open cv library

face_cascade = cv2.CascadeClassifier('haarcascade_frontalface_default.xml')

eye_cascade = cv2.CascadeClassifier('haarcascade_eye.xml')

eye_cascade_glass = cv2.CascadeClassifier('haarcascade_eye_tree_eyeglasses.xml')
# importing xml file to detect faces

img = cv2.imread('img.jpg')

# reading image present in the directory
gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)

# Converting image color to gray scale
faces = face_cascade.detectMultiScale(gray, 1.3, 5)
eyes = eye_cascade.detectMultiScale(gray, 1.3, 5)
eyes_glass = eye_cascade_glass.detectMultiScale(gray, 1.3, 5)
# detect Multi scale function to scale a within parameters

for (x, y, w, h) in faces:
    img = cv2.rectangle(img, (x, y), (x+w, y+h), (0, 0, 255), 2)

for (x, y, w, h) in eyes:
    img = cv2.rectangle(img, (x, y), (x + w, y + h), (0, 0, 255), 2)
"""
for (x, y, w, h) in eyes_glass:
    img = cv2.rectangle(img, (x, y), (x + w, y + h), (0, 0, 255), 2)
"""
    # providing a loop to draw rectangles on detected faces
    # (0,0,255) indicates red color and 2 indicates the width of the rectangle

cv2.imshow('output', img)
cv2.waitKey(0)
cv2.destroyAllWindows()
