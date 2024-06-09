import random
import time

class Coordinator:
    def __init__(self, participants):
        self.participants = participants

    def send_prepare(self):
        votes=[]
        for participant in self.participants:
            try:
                vote = participant.prepare()
                votes.append(vote)
            except Exception as e:
                print(str(e))
                self.send_abort()
        if all(votes):
            self.send_commit()
        else:
            self.send_abort()

    def send_commit(self):
        for participant in self.participants:
            try:
                participant.commit()
            except Exception as e:
                print(str(e))
                self.abort()

    def send_abort(self):
        for participant in self.participants:
            try:
                participant.abort()
            except Exception as e:
                print(str(e))
                self.abort()

class Participant:

    def __init__(self, name):
        self.name = name

    def prepare(self):
        print(f"{self.name}: Prepare phase")
        time.sleep(random.uniform(0.5, 1.5))
        return True
    
    def abort(self):
        print(f"{self.name}: Abort phase")
        time.sleep(random.uniform(0.5, 1.5))
        pass
            
    def commit(self):
        print(f"{self.name}: Commit phase")
        time.sleep(random.uniform(0.5, 1.5))
        pass

participant1 = Participant("Participant 1")
participant2 = Participant("Participant 2")

coordinator = Coordinator([participant1, participant2])

try:
    coordinator.send_prepare()
    print("Transactions Committed Successfully!!")
except Exception as e:
    print(f"Transaction aborted: {str(e)}")