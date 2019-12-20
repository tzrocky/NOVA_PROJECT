FROM python:3
ADD __main__.py /
#RUN apk add --no-cache gcc musl-dev linux-headers
#RUN apt-get install -y python python-setuptools python-pip
#COPY requirements.txt requirements.txt
#RUN pip install -r requirements.txt
RUN pip install bottle
#RUN pip install _version
COPY . .
CMD [ "python", "./__main__.py" ]
#docker build -t api-bracelet .
#docker run api-bracelet
