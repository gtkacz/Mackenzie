from django.db import models


class User(models.Model):
    name = models.TextField(max_length=None)
    email = models.EmailField()
    password = models.TextField(max_length=None)
    phone = models.TextField(max_length=None)
    profile_pic = models.ImageField(
        upload_to=None, height_field=None, width_field=None, max_length=None)
    is_organizer = models.BooleanField()
    is_player = models.BooleanField()
    prefered_position = models.TextField(max_length=None)


class Matches(models.Model):
    date = models.DateField()
    time = models.TimeField()
    location = models.TextField(max_length=None)
    organizer = models.ForeignKey(User, on_delete=models.SET_NULL, null=True, related_name='matches_organized')
    players = models.ManyToManyField(User, related_name='matches_played')
    type = models.TextField(max_length=None)
    max_players = models.IntegerField()
    min_players = models.IntegerField()
    status = models.BooleanField()


class PlayerEvaluation(models.Model):
    evaluator = models.ForeignKey(User, on_delete=models.SET_NULL, null=True, related_name='player_evaluated')
    evaluated_player = models.ForeignKey(
        User, on_delete=models.SET_NULL, null=True, related_name='player_evaluations')
    score = models.IntegerField()
    comment = models.TextField(max_length=None)


class MatchEvaluation(models.Model):
    match = models.ForeignKey(Matches, on_delete=models.SET_NULL, null=True, related_name='match_evaluations')
    evaluator = models.ForeignKey(User, on_delete=models.SET_NULL, null=True, related_name='match_evaluated')
    score = models.IntegerField()
    comment = models.TextField(max_length=None)
    player_scores = models.ManyToManyField(PlayerEvaluation, related_name='match_evaluations_player_scores')
